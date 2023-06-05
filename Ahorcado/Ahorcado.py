from palabras import   *
from fotograma import  *
import time
import os



def juego():


    print('Bienvenido al juego del ahorcado')
    print ('Elige una categoría: ')
    print ('1. Animales')
    print ('2. Frutas')
    print ('3. Países')
    print ('4. Colores')
    print('Para salir del juego introduce 0')

    categoria = input('Introduce el número de la categoría: ')
    
    if categoria == '1':
        palabra = random.choice(nombres_animal)
        letras = [letra for letra in palabra]
    elif categoria == '2':
        palabra = random.choice(nombres_frutas)
        letras = [letra for letra in palabra]
    elif categoria == '3':
        palabra = random.choice(nombres_paises)
        letras = [letra for letra in palabra]
    elif categoria == '4':
        palabra = random.choice(nombres_colores)
        letras = [letra for letra in palabra]



    PalabraaAdivinar = ['_']*len(palabra)


    print ('La palabra a adivinar tiene', len(palabra) ,'letras')
    intentoRestantes = 6
    print (fotogramas[intentoRestantes])

    while intentoRestantes > 0:

        print (' '.join(PalabraaAdivinar))
        print ("Tienes ", intentoRestantes, "intentos")

        letra = input('Introduce una letra: ')
        if letra in letras:
            for i in range(len(letras)):
                if letras[i] == letra:
                    PalabraaAdivinar[i] = letra
                    print (' '.join(PalabraaAdivinar))
                    print (fotogramas[intentoRestantes])

            if '_' not in PalabraaAdivinar:
                print('Has ganado')
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