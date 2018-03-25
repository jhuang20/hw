//james huang
//hw12--+3R|\/|1|\|4|_  1|_|_|\|3$$
//2018-03-01
//brown apcs pd01
Q0: I think it makes it a lot easier to understand the entire code in general. You
can process the code better, and it also allows for more robustified code. 
Q1: They are processed by importing java.io, and then searching for the input by using Integer.parseInt().

Q2:If the user fails to input, it reverts to default value(8 size, 500 millisecond delay)
Q3: The recursion is so that the moves continue until a set condition(the moves are greater than the number of spaces
in the board. It is necessary for the animation or nothing will be printed out!
Q4: I expect to see an animated board, with the board reprinting with new move every x(specified by user) miliseconds.
Q5: I expect it to run for delay* number of spaces in chessboard.
Q6: ANSI stands for American National Standards Institue. iT standardizes technology in America. It is useful because 
certain codes used for certain functions will have the same meaning everywhere, which means itll be universal!
Q7: THey compared pretty similarly! The -1's i missed in my analysis of the code, but all in all, it did exactly what i predicted:
it placed an object in a random place on chessboard, and moved to another one. On the board, u can see length*length moves!
Q8: I could definitely visualize using this frame work for knights tour. It's basically a stepper, allowing me to see where the knight moves each recursive
step. In fact, one only needs to add an "undo"function. 
LATEST ALGO
1.	Choose random position on borad
2.	Find possible position for knight in 6X6 radius, move it there, then record the move number.
3.	IF There are no possible positions, then move back to previous position, and try to find another position.
a.	If there are no moves available, then keep on backtracking until there is another “path of possibility”
4.	ELSE  move it into an available position.
Continue until:
a.	There are squares that are unreachable
b.	All squares have been visited