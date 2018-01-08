from sklearn.externals import joblib
import numpy as np

#load NN model data
clf = joblib.load('NN_Model.pkl')

#get input
arr = np.zeros(28 * 28).reshape(1, -1)

#calculate output
print(clf.predict(arr))
