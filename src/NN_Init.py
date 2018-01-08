from sklearn.neural_network import MLPClassifier
import os
import struct
import numpy as np
from scipy import misc as sc
import time
from sklearn.externals import joblib
import sys


class NeuralNetworkFit():
    """
    a neural network made to fit to the MNIST dataset by using the scikit learn package
    and store the model in a separate file to save time fitting
    also used for testing and analysis of the NN

    list of neural network parameters (e.g. hidden layer sizes, value of alpha, etc) and reasons for using them:
    -hidden layer size(1000, 500, 100): for now, NN is smaller for faster processing time
    """

    def __init__(self):
        """
        use the retrieved MNIST data to fit the NN and store the NN model in a separate file

        :return:    nothing
        """

        # constants
        self.PATH = "../Data/"  # the directory the data is in
        self.MODELFILENAME = "NN_Model.pkl"  # the file to store the weights in
        self.HIDDEN_LAYER_SIZE = (1000, 500, 100)

        # refit:   if True: NN model will refit itself (takes time), if False: NN model will use past fitting data
        # if the past fitting data does not exist, NN model will refit itself
        refit = sys.argv[0]

        if (not os.path.isfile(self.MODELFILENAME)) or (refit):
            self.fit()

        # else do nothing as the NN model data will be loaded in NN_Predict

        print("Neural Network Initialized")

    def fit(self):
        """
        use the retrieved MNIST data to fit the NN and store the NN model in a separate file

        :return: nothing
        """

        # get the data
        self.trainInputs, self.trainOutputs = self.getTrainData()
        self.testInputs, self.testOutputs = self.getTestData()

        """-----would only save about 2 minutes if added in-----"""
        # #lower resolution of images/inputs
        # def resize(image):
        #     image.resize(28, 28)
        #     return sc.imresize(image, 50)
        #
        # self.trainInputs = np.apply_along_axis(resize, 1, self.trainInputs)
        # self.testInputs = np.apply_along_axis(resize, 1, self.testInputs)
        #
        # #resize inputs (done only if the image resolution os lowered)
        # self.trainInputs = self.trainInputs.reshape(60000, 14*14)
        # self.testInputs = self.testInputs.reshape(10000, 14*14)
        """-----------------------------------------------------"""

        # normalize data
        self.trainInputs = self.trainInputs / 255.0
        self.testInputs = self.testInputs / 255.0

        # fit the data
        self.clf = MLPClassifier(solver='lbfgs', alpha=1e-5,
                                 hidden_layer_sizes=self.HIDDEN_LAYER_SIZE)  # may take a significant amount of time

        # print("start fitting NN")
        # start = time.time()
        self.clf.fit(self.trainInputs, self.trainOutputs)
        # print("end fitting NN: ", time.time() - start)

        # store the data so NN doesn't have to refit later
        joblib.dump(self.clf, self.MODELFILENAME)

    def getTrainData(self):
        """
        get the training data from the MNIST dataset in the form of numpy arrays
        each element in the inputs array is a 28 x 28 numpy or a image
        each element in the outputs array is a integer form 0-9 or a label

        :return: the inputs and the outputs of the neural network as a numpy array
        """

        # go to the path of the MNIST files
        trainImageFileName = os.path.join(self.PATH, 'train-images-idx3-ubyte')
        trainLabelFileName = os.path.join(self.PATH, 'train-labels-idx1-ubyte')

        # store file info into numpy arrays
        with open(trainLabelFileName, 'rb') as trainLabelFile:
            trainLabelFile.seek(8)  # skip unessesary info
            outputs = np.fromfile(trainLabelFile, dtype=np.int8)  # store as int8's as values are from 0-255

        with open(trainImageFileName, 'rb') as trainImageFile:
            trainImageFile.seek(16)  # skip unessesary info
            inputs = np.fromfile(trainImageFile, dtype=np.uint8).reshape(len(outputs),
                                                                         28 * 28)  # store as int8's as values are from 0-255

        return inputs, outputs

    def getTestData(self):
        """
        get the testing data from the MNIST dataset in the form of numpy arrays
        each element in the inputs array is a 28 x 28 numpy or a image
        each element in the outputs array is a integer form 0-9 or a label

        :return: the inputs and the outputs of the neural network as a numpy array
        """

        # go to the path of the MNIST files
        testImageFileName = os.path.join(self.PATH, 't10k-images-idx3-ubyte')
        testLabelFileName = os.path.join(self.PATH, 't10k-labels-idx1-ubyte')

        # store file info into numpy arrays
        with open(testLabelFileName, 'rb') as testLabelFile:
            testLabelFile.seek(8)  # skip unessesary info
            outputs = np.fromfile(testLabelFile, dtype=np.int8)  # store as int8's as values are from 0-255

        with open(testImageFileName, 'rb') as testImageFile:
            testImageFile.seek(16)  # skip unessesary info
            inputs = np.fromfile(testImageFile, dtype=np.uint8).reshape(len(outputs),
                                                                        28 * 28)  # store as int8's as values are from 0-255

        return inputs, outputs


NeuralNetworkFit()  # do the init command
print("it works")
with open("test.txt", 'w') as file:
    file.write("it works")