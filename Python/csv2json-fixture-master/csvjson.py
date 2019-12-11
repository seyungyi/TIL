import csv
import codecs
import json
import os
import re
import sys

# Options
ENCODING = 'utf-8'
CSV_DELIMITER = ';'

# Check arguments
try:
  script, input_name, model_name = sys.argv
except ValueError:
  print('\nRun via:\n\n%s input_name model_name' % sys.argv[0])
  print('\ne.g. %s airport.csv app_airport.Airport' % sys.argv[0])
  print('\nNote: input_name should be a path relative to where this script is.')
  sys.exit()

# Compute file paths and names
csvFilePath = os.path.dirname(__file__) + input_name
if len(re.findall('\.csv$', input_name)) != 0:
  output_name = re.sub('\.csv$', '.json', input_name)
else:
  output_name += '.json'
jsonFilePath = os.path.dirname(__file__) + output_name

#read the csv and add the data to a dictionary
entries = []
with open (csvFilePath) as csvFile:
    csvReader = csv.DictReader(csvFile)
    for csvRow in csvReader:
        row_dict = {}
        row_dict['pk'] = int(csvRow['id'])
        row_dict['model'] = model_name
        del csvRow['id']
        row_dict['fields'] = csvRow
        entries.append(row_dict)
print(entries)
csvFile.close()

# write the data toa json file
with open(jsonFilePath, 'w') as jsonFile:
    jsonFile.write(json.dumps(entries, indent=4, ensure_ascii=False))
jsonFile.close()
