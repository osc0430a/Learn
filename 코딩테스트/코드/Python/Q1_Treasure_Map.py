n = 5
arr1 = [9, 20, 28, 18, 11]
arr2 = [30, 1, 21, 17, 28]

# n = 6
# arr1 = [46, 33, 33, 22, 31, 50]
# arr2 = [27, 56, 19, 14, 14, 10]


def decode(first, second):
    arr = []

    for f, s in zip(first, second):

        arr.append(bin(f | s))

    return arr


def draw(tm):
    tmp_map = []

    for li in tm:
        string = str(li).replace("0b", "")

        while len(string) < n:
            string = "0" + string

        string = string.replace("1", "#")
        string = string.replace("0", " ")
        tmp_map.append(string)

    return tmp_map


if __name__ == "__main__":
    treasure_map = decode(arr1, arr2)
    answer = draw(treasure_map)

    print("n = ", n)
    print("arr1 = ", arr1)
    print("arr2 = ", arr2)
    print(answer)

    for line in answer:
        print(line)
