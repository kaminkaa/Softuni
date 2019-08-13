function attackEventListeners() {
    $('#linkHome').on('click', showHomeView);
    $('#linkLogin').on('click', showLoginView);
    $('#linkRegister').on('click', showRegisterView);
    $('#linkListAds').on('click', showAdsView);
    $('#linkCreateAd').on('click', showCreateAdFormView);
    $('#linkLogout').on('click', logoutUser);

    $('#buttonLoginUser').on('click', loginUser);
    $('#buttonRegisterUser').on('click', registerUser);
    $('#buttonCreateAd').on('click', createAd);

    $(document).on({
        ajaxStart: function () { $('#loadingBox').show() },
        ajaxStop: function () { $('#loadingBox').hide() }
    });
}