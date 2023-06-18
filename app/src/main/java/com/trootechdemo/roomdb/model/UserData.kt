package com.trootechdemo.roomdb.model

import android.util.Patterns

class UserData {
    var userId: String? = null
    var strUserName: String? = null
    var strUserEmail: String? = null
    var strUserPhone: String? = null

    constructor() {}
    constructor(userId: String?, userName: String?, userEmail: String?, userPhone: String?) {
        this.userId = userId
        strUserName = userName
        strUserEmail = userEmail
        strUserPhone = userPhone
    }

    constructor(strUserName: String?, strUserEmail: String?, strUserPhone: String?) {
        this.strUserName = strUserName
        this.strUserEmail = strUserEmail
        this.strUserPhone = strUserPhone
    }

    val isEmailValid: Boolean
        get() = Patterns.EMAIL_ADDRESS.matcher(strUserEmail).matches()
}