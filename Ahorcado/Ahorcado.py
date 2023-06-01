from palabras import   *
from fotograma import  *
import time
import os



def juego():
    palabra = random.choice(palabras)
    letras = [letra for letra in palabra]


    PalabraaAdivinar = ['_']*len(palabra)


    print ('La palabra a adivinar tiene', len(palabra) ,'letras')
    intentoRestantes = 6
    print (fotogramas[intentoRestantes])

    while intentoRestantes > 0:

        print (PalabraaAdivinar)
        print ("Tienes ", intentoRestantes, "intentos")

        letra = input('Introduce una letra: ')
        if letra in letras:
            for i in range(len(letras)):
                if letras[i] == letra:
                    PalabraaAdivinar[i] = letra
                    print (PalabraaAdivinar)
                    print (fotogramas[intentoRestantes])

            if '_' not in PalabraaAdivinar:
                print('Has ganado')
                time.sleep(10)
                exit()
        elif letra == '0':
            print('Has salido del juego')
            time.sleep(10)
            exit()
        else:
            print('La letra no está en la palabra')
            intentoRestantes -= 1
            print (fotogramas[intentoRestantes])
            
    print('La palabra era', palabra)
    print('Has perdido')
    intento = input('Intentalo de nuevo? : S/N  :')
    if intento == 's':
        if os.name == 'nt':  # Windows
            os.system('cls')
            juego()
        else:  # Unix/Linux/Mac
            os.system('clear')
            juego()
    else:
        print('Has salido del juego')
        time.sleep(10)
        exit()

juego()