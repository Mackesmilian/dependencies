import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "should return when customer all is called"
    request{
        method GET()
        url("/customers") {
        }
    }
    response {
        body("[{\"name\":\"Franz\",\"address\":\"Skreet 1\",\"email\":\"mail@gmail.com\",\"statusFl\":true},{\"name\":\"Herbert\",\"address\":\"Strasse 1\",\"email\":\"mail1@gmail.com\",\"statusFl\":true},{\"name\":\"Günther\",\"address\":\"Skreet 1\",\"email\":\"mail2@gmail.com\",\"statusFl\":false}]")
        status 200
    }
}