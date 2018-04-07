from sklearn.externals import joblib
from sklearn.neural_network import MLPClassifier
import numpy as np
import os

def main():
    # load NN model data
    path = os.path.dirname(os.path.realpath(__file__)) + '\\NN_Model.pkl'
    clf = joblib.load(path)

    # get input
    arr = np.zeros(28 * 28).reshape(1, -1)

    # output result
    print(clf.predict(arr)[0])


if __name__ == '__main__':
    main()

