Algorithm for Solution class:

Create a class named Solution.
Declare and initialize two static integer arrays:
dx to store x-coordinate offsets for 8 directions.
dy to store y-coordinate offsets for 8 directions.
Define the searchWord method with the following parameters:
grid : a 2D character array representing the grid of characters.
word : a string representing the target word to be found in the grid.
Inside the searchWord method:
Get the number of rows (rows) and columns (cols) from the grid.
Initialize an empty ArrayList named result to store the result coordinates.
Loop through each row index i from 0 to rows-1:
Loop through each column index j from 0 to cols-1:
Check if the current character in the grid matches the first character of the word.
If not, continue to the next iteration.
Loop through all 8 directions (dir = 0 to 7):
Calculate the new x-coordinate x and y-coordinate y based on the current direction.
Check if the calculated coordinates (x, y) are within the grid bounds:
If not, continue to the next direction.
Call the searchDirection method with the following arguments:
grid, i, j, word, dir.
If the method returns true, add the starting coordinates (i, j) to the result and break the loop.
Convert the result list to a 2D integer array named ans:
Loop through each index i in the result list:
Get the row coordinate from result[i][0].
Get the column coordinate from result[i][1].
Store the row and column coordinates in ans[i].
Return the ans array.
Define a private method isValid with the following parameters:
x, y : integer coordinates.
rows, cols : dimensions of the grid.
Return true if the given coordinates (x, y) are within the grid bounds, otherwise return false.
Define a private method searchDirection with the following parameters:
grid : 2D character array representing the grid.
row, col : starting coordinates in the grid.
word : the target word to be found.
dir : direction index (0 to 7).
Get the length of the word and store it in len.
Loop through each character index k from 0 to len-1:
Calculate the new x-coordinate x and y-coordinate y based on the direction and index k.
Check if the calculated coordinates (x, y) are within the grid bounds and if the character at those coordinates matches the character at index k of the word.
If not, return false indicating the word doesn't match in this direction.
If all characters match in the given direction, return true.
End
