package contracts.Bread

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description('''
given
when
 /bread/{breadName} was called
then
 return bread object
''')
    request {
        method 'GET'
        url '/bread/bagel'
    }
    response {
        status 200
        body(
                [
                    name:'bagel'
                ]
        )
        headers {
            contentType(applicationJson())
        }
    }
}
