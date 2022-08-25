package br.com.poc.grpcPoc.adapters.grpc

import br.com.poc.grpcPoc.adapters.grpc.Person.PersonRequest
import br.com.poc.grpcPoc.adapters.grpc.Person.PersonResponse
import io.grpc.stub.StreamObserver
import org.springframework.stereotype.Service

@Service
class PersonService: PersonServiceGrpc.PersonServiceImplBase() {

    override fun consultaPessoa(request: PersonRequest?, responseObserver: StreamObserver<PersonResponse>?) {
        val person = PersonResponse
            .newBuilder()
            .setName("Nome de teste")
            .setEmail("teste@teste.com")
            .setId(2).build()
        responseObserver?.onNext(person)
        responseObserver?.onCompleted()
    }
}
