import json
import string
import csv
import sys
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, Integer, String
from sqlalchemy.sql import select
from textblob.classifiers import NaiveBayesClassifier
import pandas as pd
import numpy as np
from dateutil import parser

engine = create_engine('mysql://root:root@localhost:3306/FYP', echo=False)
Base = declarative_base()

class MyTable(Base):
        __tablename__ = 'stringclassifier'
        id = Column(Integer, primary_key=True)
        word = Column(String(100))
        category = Column(String(100))
        def __init__(self, name, value):
                self.word = name
                self.category = value
        def __repr__(self):
                return "<MyTable(%s, %s)>" % (self.name, self.role)
#------------------------------------------------------------------------
class Column:
    def __init__(self):
        self.Heading = None
        self.ColumnId =0
        self.IsContinous = False
        self.NoOfDiscreteValues = 0
        self.Context = None
        self.ClassificationByHeading = None
    def to_JSON(self):
        return json.dumps(self, default=lambda o: o.__dict__)    
class Table:
    def __init__(self):
        self.Id = 0
        self.NumOfRows =0
        self.Data = []
        self.Intension = 0
        self.columnCount=0
    def to_JSON(self):
        return json.dumps(self, default=lambda o: o.__dict__)
#-----------------------------------------------------------------------    
cl = None #classifier
headerContext = [] #csv header
tbl = Table() #global table variable
columnList = [] #global column list
csvHeader = []
#-----------------------------------------------------------------------
def RepresentsInt(s):
    try: 
        int(s)
        return True
    except ValueError:
        return False
def RepresentsFloat(s):
    try: 
        float(s)
        return True
    except ValueError:
        return False
def RepresentsDate(s):
    try: 
        parser.parse(s)
        return True
    except:
        return False  
#-----------------------------------------------------------------------
def loadClassifier():
    words = []
    conn = engine.connect()
    s = select([MyTable])
    result = conn.execute(s)
    for row in result:
        words.append((row[1],row[2]))
    global cl
    cl= NaiveBayesClassifier(words)
    
#------------------------------------------------------------------------
def classifyHeader(argv):
    global headerContext    
    global csvHeader
    df = pd.read_csv(argv[0])
    csvHeader=list(df.columns.values)
    for str in csvHeader:
        str = str.lower()
        newstring = str.replace('_',' ').replace(',',' ')
        strarr = newstring.split(' ')
        probability = []
        types =[]

        for word in strarr:
            temp = cl.prob_classify(word)
            probability.append(round(temp.prob(temp.max()), 2))
            types.append(temp.max())

        maxProb = max(probability)
        if(maxProb >= 0.5):
            index = probability.index(max(probability))
            headerContext.append(types[index])
        else:
            headerContext.append("Not classified")
#---------------------------------------------------------------------------
def classifyBody(argv):
    global tbl
    global columnList
    global headerContext
    df = pd.read_csv(argv[0])
    rows =df.shape[0]
    tbl.NumOfRows = rows
    cols = df.shape[1]
    tbl.columnCount = cols
    for r in range(cols):
        col = Column()
        col.ColumnId = r
        columnList.append(col)
    iterations = 100 
    if rows < 100 :
        iterations = rows
    for i in range(cols):
        tempdf = df[[i]]
        floatArr = []
        intArr = []
        dateArr=[]
        strArr = []
        for index,row in tempdf.iterrows():
            if index < iterations:
                temholder = row[[0]][0]
                if RepresentsDate(temholder):
                    dateArr.append(temholder)
                if RepresentsFloat(temholder):
                    floatArr.append(temholder)
                if RepresentsInt(temholder):
                    intArr.append(temholder)
                else:
                    strArr.append(temholder)    
        lendate = len(dateArr)
        lenfloat = len(floatArr)
        lenint = len(intArr)
        lenstr = len(strArr)
        columnList[i].Heading = csvHeader[i]
        columnList[i].ClassificationByHeading = headerContext[i]
        if lendate > .6 * iterations:
            columnList[i].Context = "DateTime"
            columnList[i].NoOfDiscreteValues = len(set(dateArr))
            if(len(set(dateArr))> .5 * iterations):
                columnList[i].IsContinous = True
            else:
                columnList[i].IsContinous = False
        elif (lenfloat + lenint) * iterations:
            columnList[i].Context = "Numerical"
            columnList[i].NoOfDiscreteValues =len(set(intArr)) + len(set(floatArr))
            if((len(set(intArr)) + len(set(floatArr))) > .5 * iterations):
                columnList[i].IsContinous = True
            else:
                columnList[i].IsContinous = False
        else:
            columnList[i].Context = "Nominal"
            columnList[i].NoOfDiscreteValues = len(set(strArr))
            if(len(set(strArr))> .5 * iterations):
                columnList[i].IsContinous = True
            else:
                columnList[i].IsContinous = False
#---------------------------------------------------------------------------            
def main(argv):
    loadClassifier()
    classifyHeader(argv)
    classifyBody(argv)
    global tbl
    global columnList
    tbl.Data = columnList
    #s = json.dumps(tbl.__dict__)
    print(tbl.to_JSON())

if __name__ == "__main__":
    #main()
    main(sys.argv[1:])

