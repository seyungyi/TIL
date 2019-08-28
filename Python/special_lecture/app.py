# pip install flask
from flask import Flask

app = Flask(__name__)

@app.route('/lotto')



def lotto():
    import random
    numbers = range(1, 46)
    print(list(numbers))
    lotto = random.sample(numbers, 6)
    return str(sorted(lotto))
# flask run : 서버 실행 명령