from sklearn.neural_network import MLPClassifier

class NeuralNetworkFit():
    """
    a neural network made to fit to the MNIST dataset by using the scikit learn package
    and store the weight values in a separate file for later use
    also used for testing and analysis of the NN

    list of neural network parameters (e.g. hidden layer sizes, value of alpha, etc) and reasons for using them:
    -hidden layer size(1000, 500, 100): for now, NN is smaller for faster processing time
    """

    def __init__(self):
        #get the data
        self.X, self.Y = self.getData()

        #fit the data
        self.clf = MLPClassifier(solver='lbfgs', alpha=1e-5, hidden_layer_sizes=(1000, 500, 100), random_state=1)
        self.clf.fit(self.X, self.Y)

        #write the data
        self.FILENAME = "Weights.txt"
        self.writeWeights()

    def getData(self):
        """
        get data from the MNIST dataset in the form of numpy arrays

        :return: the inputs(X) and the outputs(y) of the neural network as a numpy array
        """

        X = None
        Y = None

        return X, Y

    def writeWeights(self):
        """
        write the weights of the neural network to a text file

        :return: nothing
        """



NeuralNetworkFit()  #do the init command