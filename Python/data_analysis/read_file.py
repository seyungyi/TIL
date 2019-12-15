import pandas as pd

dataList = pd.read_csv("../csv2json-fixture-master/test2.csv", engine="python")
print(dataList)

print(dataList.to_json(orient='columns'))