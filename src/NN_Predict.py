from sklearn.externals import joblib
from sklearn.neural_network import MLPClassifier
import numpy as np
import os
from PIL import Image
import cv2

def main():
    # load NN model data
    path = os.path.dirname(os.path.realpath(__file__)) + '\\NN_Model.pkl'
    clf = joblib.load(path)

    #get image from GUI
    imgPath = os.path.dirname(os.path.realpath(__file__)) + '\\Drawing.png'
    img = Image.open(imgPath)

    #format image for NN
    img = img.resize((28, 28), Image.BOX) #BOX is the fastest while conserving a decent amount of pixels
    img = img.convert("L")  #1 byte per pixel
    img = img.point(lambda p: 0 if p != 255 else 255)  # pixel is black(0) if not white(255)
    img = img.point(lambda p: 255-p) #switch to black and white like in input data
    imgArray = np.array(img.getdata(), np.uint8).reshape(1, -1)
    imgArray = imgArray / 255.0 #normalize data

    img.close()

    # output result
    print(clf.predict(imgArray)[0])

if __name__ == '__main__':
    main()

