package com.jhonny.coolstore.domain.base

import com.jhonny.coolstore.data.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * It can be used for use cases that return Unit, Boolean, Int, etc.
 * No mapper needed
 */
abstract class SuspendUseCase<in Params, out Results>(
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(parameters: Params): Result<Results> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters)
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: Params): Result<Results>
}

suspend operator fun <Results> SuspendUseCase<Unit, Results>.invoke(): Result<Results> = this(Unit)
