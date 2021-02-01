Q1 = ['Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA', 'Jeju', 'Pangyo', 'Seoul',
      'NewYork', 'LA']
Q2 = ['Jeju', 'Pangyo', 'Seoul', 'Jeju', 'Pangyo', 'Seoul', 'Jeju', 'Pangyo',
      'Seoul']
Q3 = ['Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA', 'SanFrancisco', 'Seoul',
      'Rome', 'Paris', 'Jeju', 'NewYork', 'Rome']
Q4 = ['Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA', 'SanFrancisco', 'Seoul',
      'Rome', 'Paris', 'Jeju', 'NewYork', 'Rome']
Q5 = ['Jeju', 'Pangyo', 'NewYork', 'newyork']
Q6 = ['Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA']

QC1 = 3
QC2 = 3
QC3 = 2
QC4 = 5
QC5 = 2
QC6 = 0


def cal(cache_size, cities):
    cache = [None] * cache_size
    time = 0

    if cache_size == 0:
        print('Cache Size is 0')
        return len(cities*5)
    elif cache_size > 30:
        print('Cache Size Error')
        return -1

    for city in cities:
        city = city.lower()
        if city in cache:
            cache.pop(cache.index(city))
            cache.append(city)
            time += 1
        elif len(cache) < cache_size:
            cache.append(city)
            time += 5
        else:
            cache.pop(0)
            cache.append(city)
            time += 5
        print(cache)

    return time


if __name__ == '__main__':
    answer = cal(QC6, Q6)
    print(answer)
