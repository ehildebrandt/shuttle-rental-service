import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description("should return a list of frauds")
    request {
        url "/fraud"
        method GET()
    }
    response {
        status(200)
        body(["Spock", "Kirk"])
    }
}