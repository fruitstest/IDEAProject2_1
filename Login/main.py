from flask import render_template,Flask
app = Flask(__name__)

@app.route('/index')
def index():
    return render_template('index.html')
@app.route('/login')
def login():
    return render_template('login.html')
@app.route('/homepage')
def homepage():
    return render_template('homepage.html')
app.run(port=1234,debug=True)