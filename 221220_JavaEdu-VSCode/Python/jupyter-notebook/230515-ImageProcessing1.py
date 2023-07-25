import cv2
import numpy as np

# 영상을 불러온다.
image = cv2.imread('dog.jpg', -1)

# -------------------------------------
# # 영상의 관심영역을 설정한다. 푸른색 영역
# roi = image[:, 200:700, 0]

# x_edge = cv2.Sobel(roi, cv2.CV_32S, 1, 0, (3, 3), 3)
# x_edge = cv2.convertScaleAbs(x_edge)

# cv2.imshow('edge', x_edge)
# cv2.waitKey()



# -------------------------------------
# # 영상의 관심영역을 설정한다. 푸른색 영역
gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
gauss = cv2.GaussianBlur(gray, (3, 3), 3)
x_edge = cv2.Sobel(gauss, cv2.CV_32F, 1, 0, 3, 1)
y_edge = cv2.Sobel(gauss, cv2.CV_32F, 0, 1, 3, 1)
x_edge = cv2.convertScaleAbs(x_edge)
y_edge = cv2.convertScaleAbs(y_edge)
lapla = cv2.Laplacian(gray, cv2.CV_32F, ksize=3)
lapla = cv2.convertScaleAbs(lapla)
thresh = cv2.threshold(lapla, 80, 255, cv2.THRESH_BINARY)[1]
dilate = cv2.dilate(thresh, kernel=np.ones((5, 5), dtype=np.uint8))

cv2.imshow('gray', gray)
# cv2.imshow('edge', x_edge)
# cv2.imshow('edgey', y_edge)
cv2.imshow('laplacian', lapla)
cv2.imshow('dilate', dilate)

cv2.waitKey()