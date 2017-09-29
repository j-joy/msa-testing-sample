package contracts.CoffeeDelivery

import org.springframework.cloud.contract.spec.Contract

    Contract.make {
        description('''
given
when
 /coffees가 호출되었을때
then
 coffee 메뉴가 리턴된다
''')
        request {
            method 'GET'
            url '/coffees'
        }
        response {
            status 200
            body(
                    [
                            [name:'Americano'],
                            [name:'Caffee Latte'],
                            [name:'Esspresso']
                    ]
            )
            headers {
                contentType(applicationJson())
            }
        }
    }