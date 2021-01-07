package com.systango.sociallogin

interface SocialAuthenticationCallback {
    /**
     * Calls when login was successful
     *
     * @param socialNetwork [SocialAuthentication] implementation in which login was requested
     * @param autnResult [SocialAuthResult] authorization token and some user data
     */
    fun onLoginSuccess(socialAuthentication: SocialAuthentication, autnResult: SocialAuthResult)

    /**
     * Calls when some error occurred
     *
     * @param socialNetwork [SocialAuthentication] implementation with which request was unsuccessful
     * @param error [SocialAuthError] error a social login error
     */
    fun onLoginError(socialAuthentication: SocialAuthentication, error: SocialAuthError)
}