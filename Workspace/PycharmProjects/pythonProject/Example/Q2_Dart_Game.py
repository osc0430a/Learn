Q1 = '1S2D*3T'
Q2 = '1D2S#10S'
Q3 = '1D2S0T'
Q4 = '1S*2T*3S'
Q5 = '1D#2S*3S'
Q6 = '1T2D3D#'
Q7 = '1D2S3T*'


def cal(question):
    num = []
    tmp = 0
    cnt = 0
    while cnt < len(question):
        if question[cnt].isdigit():
            if question[cnt+1].isdigit():
                num.append(int(question[cnt] + question[cnt+1]))
                cnt += 1
                tmp += 1
            else:
                num.append(int(question[cnt]))
                tmp += 1
        elif question[cnt] == 'D':
            num[tmp-1] = num[tmp-1] ** 2
        elif question[cnt] == 'T':
            num[tmp-1] = num[tmp-1] ** 3
        elif question[cnt] == '*':
            if tmp == 1:
                num[tmp-1] *= 2
            else:
                num[tmp-1] *= 2
                num[tmp-2] *= 2
        elif question[cnt] == '#':
            num[tmp-1] *= -1
        cnt += 1
        print('num = ', num)

    return num[0] + num[1] + num[2]


if __name__ == '__main__':
    answer = cal(Q7)
    print(answer)
