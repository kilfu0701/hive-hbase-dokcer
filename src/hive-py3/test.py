from pyhive import hive

def test_case1():
    conn = hive.Connection(
                host='hive-server',
                port=10000,
                username='',
                password='pAssWord$!',
                database='mydb',
                auth="CUSTOM"
            )
    cursor = conn.cursor()

    cursor.execute("select * from users WHERE country = 'JP'")
    i = 1
    for result in cursor.fetchall():
        print(i, result)
        i = i + 1

    conn.close()


def test_case2():
    import contextlib
    with contextlib.closing(hive.connect(host='hive-server', port=10000, username='hive', auth='CUSTOM', password='pAssWord$!', database='mydb')) as connection:
        with contextlib.closing(connection.cursor()) as cursor:
            cursor.execute("select * from users WHERE country = 'US' LIMIT 1")
            res = cursor.fetchall()
            print(res)


if __name__ == '__main__':
    test_case1()
    test_case2()
