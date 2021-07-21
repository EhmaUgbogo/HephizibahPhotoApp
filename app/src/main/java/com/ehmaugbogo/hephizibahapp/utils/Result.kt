package com.ehmaugbogo.hephizibahapp.utils


/**
 * @company ..: GIGM
 * @author ..: Ehma Ugbogo
 * @email ..: emmanuel.ugbogo@thegiggroupng.com
 * @created ..: 21-07-2021
 */

sealed class Result<T>(){
    object Loading: Result<Nothing>()
    data class Failure(val error: Throwable): Result<Nothing>()
    data class Success<T>(val data: T): Result<T>()
}