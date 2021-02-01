import heapq as heap
# 09:00첫차 N회 T분간격 M명 탑승가능
N = [1, 2, 2, 1, 1, 10]
T = [1, 10, 1, 1, 1, 60]
M = [5, 2, 2, 5, 1, 45]

timeTable0 = ['08:00', '08:01', '08:02', '08:03']
timeTable1 = ['09:10', '09:09', '08:00']
timeTable2 = ['09:00', '09:00', '09:00', '09:00']
timeTable3 = ['00:01', '00:01', '00:01', '00:01', '00:01']
timeTable4 = ['23:59']
timeTable5 = ['23:59', '23:59', '23:59', '23:59', '23:59', '23:59', '23:59',
              '23:59', '23:59', '23:59', '23:59', '23:59', '23:59', '23:59',
              '23:59', '23:59']

# 힙에 직원들의 도착시간을 넣고 빠른 직원부터 뽑아서 처리.
#   가장 늦게 도착하는 버스의 도착시간을 계산한다.
#   앞 버스를 타는 사람들을 모두 뽑아낸다.
#   경쟁자의 수와 버스 정원을 비교한다.
#       정원이 많으면 버스 도착시간이 정답.
#       정원이 적으면 마지막 M명째 사람보다 1분 빠른시간.


def num_time(t):
    time = t.split(':')
    time = int(time[0]) * 60 + int(time[1])
    return time


def format_time(t):
    clock = str(t // 60)
    if len(clock) == 1:
        clock = '0' + clock
    minute = str(t % 60)
    if len(minute) == 1:
        minute = '0' + minute
    return clock + ':' + minute


def last_bus(n, t):
    tmp = (n - 1) * t
    tmp += 540
    return tmp


def past_bus(n, t, l_bus):
    if n == 1:
        return -1
    else:
        return l_bus - t


def cal_competitor(p_bus, table):
    if p_bus == -1:
        return table
    while table:
        t = heap.heappop(table)
        tmp = num_time(t)
        if tmp >= p_bus:
            heap.heappush(table, t)
            break
    return table


def solution(m, l_bus, comp):
    cnt = 0
    last_person = -1

    while comp:
        tmp = heap.heappop(comp)
        tmp = num_time(tmp)
        # print('l_bus = ', l_bus)
        # print('tmp = ', tmp)
        # print('cnt = ', cnt)
        # print('m = ', m)
        if tmp <= l_bus:
            if cnt < m:
                last_person = tmp
                cnt += 1
        else:
            break

    if last_person == -1:
        return format_time(l_bus)
    elif cnt == m:
        return format_time(last_person - 1)
    else:
        return format_time(l_bus)


if __name__ == '__main__':
    heap.heapify(timeTable5)
    lastBus = last_bus(N[5], T[5])
    pastBus = past_bus(N[5], T[5], lastBus)
    competitor = cal_competitor(pastBus, timeTable5)
    print(competitor)
    answer = solution(M[5], lastBus, competitor)
    print(answer)
