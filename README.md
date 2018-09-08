# OCR ASCII Art

ORC ASCII Art is a optical character recognition program that turns a line art drawing into ASCII text. It uses a Java interface to enable the user to create their own line art drawing. To turn the newly drawn image into text, the image is then used in a Python script to predict what text is in the image. This script will use various machine learning models like neural networks to find where the text is, find where each individual characer is, and predict what each of those characters are. After the text in the drawing as been predicted, the user can copy and paste from the interface to use the text for their own means.

Currently this project is still underway. Right now, the program can only predict one single digit number at a time. In the future, more work will be put in to create the data for most of the characters in the ASCII set. More work will also be put in to develop each of the nessesary mcahine learning models.

# Requirments
Languages:  
-Java  
-Python 3  
  Make sure your Python executable is named "python". To verify this, type "python" into your command ternimal and if the correct version   of python starts running, you're good.
  
Python Packages:  
-NumPy  
-Scikit-Learn  
-Python Imaging Library  

These Python packages are best installed with pip.

# Running the Program
Before running the program, be sure to initialize the machine learning model. This can be done by running the NN_Init.py script by typing "python NN_Init.py". To start the interface, first compile Main.java, Interface.java, and Canvas.java. Then run the compiled program to cause the Java interface to appear. The "main" function of the program is in Main.java.
