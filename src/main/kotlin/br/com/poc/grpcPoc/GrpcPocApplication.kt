package br.com.poc.grpcPoc

import io.grpc.BindableService
import io.grpc.ServerBuilder
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class GrpcPocApplication(val services: List<BindableService>): ApplicationRunner {
	override fun run(args: ApplicationArguments?) {
		val serverBuilder = ServerBuilder.forPort(9090)
		services.forEach{
			serverBuilder.addService(it)
		}
		serverBuilder
			.build()
			.start()
	}
}

fun main(args: Array<String>) {
	runApplication<GrpcPocApplication>(*args)
}
