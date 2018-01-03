from sklearn.neural_network import MLPClassifier
import os
import struct
import numpy as np

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
        #TODO: see about making the inputs and outputs generators instead of iterators
        self.trainInputs, self.trainOutputs = self.getTrainData()
        self.testInputs, self.testOutputs = self.getTestData()

        #fit the data
        self.clf = MLPClassifier(solver='lbfgs', alpha=1e-5, hidden_layer_sizes=(1000, 500, 100), random_state=1)
        #self.clf.fit(self.inputs, self.outputs)

        #write the data
        self.writeWeights()

    def getTrainData(self):
        """
        get the training data from the MNIST dataset in the form of numpy arrays

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
        inputs = np.fromfile(trainImageFile, dtype=np.uint8).reshape(len(outputs), 28, 28) #store as int8's as values are from 0-255
        trainImageFile.close()

        return inputs, outputs

    def getTestData(self):
        """
        get the testing data from the MNIST dataset in the form of numpy arrays

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
        inputs = np.fromfile(testImageFile, dtype=np.uint8).reshape(len(outputs), 28, 28) #store as int8's as values are from 0-255
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