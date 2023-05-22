def solve_n_queens(n):
    solutions = []  # lista de soluciones
    board = [-1] * n  # -1 indica que no hay reina en esa fila
    backtrack(board, 0, solutions)  # backtracking
    return solutions  # retorna la lista de soluciones


def backtrack(board, row, solutions):
    if row == len(board):  # si ya se colocaron todas las reinas
        solutions.append(list(board))  # se agrega la solucion
        return  # se termina la recursion
    for col in range(len(board)):  # se recorre cada columna
        if is_valid(board, row, col):  # si la posicion es valida
            board[row] = col  # se coloca la reina
            backtrack(board, row + 1, solutions)  # se continua con la siguiente fila
            board[row] = -1  # se quita la reina


def is_valid(board, row, col):  # verifica si la posicion es valida
    for r in range(row):  # se recorre cada fila anterior
        if (
            board[r] == col or board[r] - r == col - row or board[r] + r == col + row
        ):  # si hay una reina en la misma columna o en la misma diagonal
            return False  # la posicion no es valida
    return True  # la posicion es valida


if __name__ == "__main__":
    reinas = int(input("Coloque el numero de reinas que desea analizar:"))
    solutions = solve_n_queens(reinas)

    print(f"Se encontro {len(solutions)} soluciones para {reinas}-reinas:")
    for i, s in enumerate(solutions):
        print(f"solucion [{i + 1}]: {s}")
    print("\n")
    print(
        "Los resutados se muestran en array, donde cada numero representa la columna en la que se encuentra la reina en la fila correspondiente"
    )
    print(
        "Por ejemplo, la solución [0, 4, 7, 5, 2, 6, 1, 3] indica que la reina en la fila 0 se ubica en la columna 0, la reina en la fila 1 se ubica en la columna 4, y así sucesivamente"
    )
    respuesta = input("Presione enter para  para salir")
