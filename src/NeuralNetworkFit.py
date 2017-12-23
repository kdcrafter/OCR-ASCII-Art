from sklearn.neural_network import MLPClassifier

class NeuralNetworkFit():
    """
    summary:    a neural network made to fit to the MNIST dataset by using the scikit learn package
                and store the weight values in a separate file for later use
    """

    def __init__(self):
        #get the data
        self.X, self.Y = self.getData()

        #fit the data
        self.clf = MLPClassifier(solver='lbfgs', alpha=1e-5, hidden_layer_sizes=(5, 2), random_state=1)
        self.clf.fit(self.X, self.Y)

        #write the data
        self.FILENAME = "Weights.txt"
        self.writeWeights()

    def getData(self):
        """
        summary:    get data from the MNIST dataset in the form of numpy arrays

        return:    the inputs(X) and the outputs(y) of the neural network
        return type:    numpy array
        """
        X = None
        Y = None

        return X, Y

    def writeWeights(self):
        """
        summary:    write the weights of the neural network to a text file
        """



NeuralNetworkFit()  #do the init command