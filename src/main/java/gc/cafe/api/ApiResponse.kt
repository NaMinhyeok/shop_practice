package gc.cafe.api

import org.springframework.http.HttpStatus

data class ApiResponse<T>(
    val status: HttpStatus,
    val message: String,
    val data: T
) {
    val code = status.value()

    companion object {
        fun <T> of(httpStatus: HttpStatus, message: String, data: T): ApiResponse<T> {
            return ApiResponse(httpStatus, message, data)
        }

        fun <T> of(httpStatus: HttpStatus, data: T): ApiResponse<T> {
            return of(httpStatus, httpStatus.name, data)
        }

        fun <T> ok(data: T): ApiResponse<T> {
            return of(HttpStatus.OK, data)
        }

        fun <T> created(data: T): ApiResponse<T> {
            return of(HttpStatus.CREATED, data)
        }
    }
}
