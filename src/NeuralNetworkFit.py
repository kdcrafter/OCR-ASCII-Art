from sklearn.neural_network import MLPClassifier
import os
import struct
import numpy as np
from scipy import misc as sc

class NeuralNetworkFit():
    """
    a neural network made to fit to the MNIST dataset by using the scikit learn package
    and store the weight values in a separate file for later use
    also used for testing and analysis of the NN

    list of neural network parameters (e.g. hidden layer sizes, value of alpha, etc) and reasons for using them:
    -hidden layer size(1000, 500, 100): for now, NN is smaller for faster processing time
    """

    def __init__(self):
        #constants
        self.PATH = "../Data/"  #the directory the data is in
        self.FILENAME = "Weights.txt" #the file to store the weights in

        #get the data
        self.trainInputs, self.trainOutputs = self.getTrainData()
        self.testInputs, self.testOutputs = self.getTestData()

        #lower resolution of images/inputs
        def resize(image):
            image.resize(28, 28)
            return sc.imresize(image, 50)

        self.trainInputs = np.apply_along_axis(resize, 1, self.trainInputs)
        self.testInputs = np.apply_along_axis(resize, 1, self.testInputs)

        #resize inputs
        self.trainInputs = self.trainInputs.reshape(60000, 14*14)
        self.testInputs = self.testInputs.reshape(10000, 14*14)

        #normalize data
        self.trainInputs = self.trainInputs / 255.0
        self.testInputs = self.testInputs / 255.0

        #fit the data
        self.clf = MLPClassifier(solver='lbfgs', alpha=1e-5, hidden_layer_sizes=(1000, 500, 100))   #may take a significant amount of time

        self.clf.fit(self.trainInputs, self.trainOutputs)

        #write the data
        self.writeWeights()

    def getTrainData(self):
        """
        get the training data from the MNIST dataset in the form of numpy arrays
        each element in the inputs array is a 28 x 28 numpy or a image
        each element in the outputs array is a integer form 0-9 or a label

        :return: the inputs and the outputs of the neural network as a numpy array
        """

        #go to the path of the MNIST files
        trainImageFileName = os.path.join(self.PATH, 'train-images-idx3-ubyte')
        trainLabelFileName = os.path.join(self.PATH, 'train-labels-idx1-ubyte')

        #store file info into numpy arrays
        trainLabelFile = open(trainLabelFileName, 'rb')
        trainLabelFile.seek(8) #skip unessesary info
        outputs = np.fromfile(trainLabelFile, dtype=np.int8) #store as int8's as values are from 0-255
        trainLabelFile.close()

        trainImageFile = open(trainImageFileName, 'rb')
        trainImageFile.seek(16) #skip unessesary info
        inputs = np.fromfile(trainImageFile, dtype=np.uint8).reshape(len(outputs), 28*28) #store as int8's as values are from 0-255
        trainImageFile.close()

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

        #store file info into numpy arrays
        testLabelFile = open(testLabelFileName, 'rb')
        testLabelFile.seek(8) #skip unessesary info
        outputs = np.fromfile(testLabelFile, dtype=np.int8) #store as int8's as values are from 0-255
        testLabelFile.close()

        testImageFile = open(testImageFileName, 'rb')
        testImageFile.seek(16) #skip unessesary info
        inputs = np.fromfile(testImageFile, dtype=np.uint8).reshape(len(outputs), 28*28) #store as int8's as values are from 0-255
        testImageFile.close()

        return inputs, outputs

    def writeWeights(self):
        """
        write the weights of the neural network to a text file

        :return: nothing
        """

        # get weights
        #weights = self.clf.coefs_

        # format weights

        #open file

        #write weights to file

NeuralNetworkFit()  #do the init command