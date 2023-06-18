package com.trootechdemo.roomdb.model

class LoginModel {
    var data: DataBean? = null

    class DataBean {
        var id = 0
        var first_name: String? = null
        var ar_first_name: String? = null
        var last_name: String? = null
        var email: String? = null
        var post_mail: String? = null
        var mobile: String? = null
        var age: String? = null
        var password: String? = null
        var gender: String? = null
        var date_of_birth: String? = null
        var profile_pic: String? = null
        var device_id: String? = null
        var language: String? = null
        var insurance_company_name: String? = null
        var insurance_policy_no: String? = null
        var description: String? = null
        var ar_description: String? = null
        var emr_number: String? = null
        var start_time: String? = null
        var end_time: String? = null
        var status = 0
        var is_insurance: String? = null
        var payment_type: String? = null
        var paymentdetails_id: String? = null
        var insurance_id: String? = null
        var quickblox_id: String? = null
        var sinch_ticket: String? = null
        var national_id: String? = null
        var wallet_money: String? = null
        var fees: String? = null
        var discount: String? = null
        var created_at: String? = null
        var updated_at: String? = null
        var role: String? = null
        var token: String? = null
        var tokens: List<TokensBean>? = null

        class TokensBean {
            /**
             * id : 3ed956aa6f87899daff4fbb1b57f3cc4fe088f09c2451726ec0e3f405a492158a098bc6b0d859186
             * user_id : 505
             * client_id : 1
             * name : MyApp
             * scopes : []
             * revoked : false
             * created_at : 2019-11-27 13:56:01
             * updated_at : 2019-11-27 13:56:01
             * expires_at : 2020-11-27 13:56:01
             */
            var id: String? = null
            var user_id: String? = null
            var client_id: String? = null
            var name: String? = null
            var isRevoked = false
            var created_at: String? = null
            var updated_at: String? = null
            var expires_at: String? = null
            var scopes: List<*>? = null
        }
    }
}