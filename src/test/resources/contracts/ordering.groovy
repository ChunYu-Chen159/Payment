package contracts

import org.springframework.cloud.contract.spec.Contract
[
    Contract.make {
        description ("payment Contract")
        name ("ordering_payment")
        request {
            method ("GET")
            url("/payment") {
                queryParameters {
                    parameter("userID", 1)
                    parameter("price", "250")
                }
            }
        }
        response {
            body("succe")
            status (200)
        }
    }
]