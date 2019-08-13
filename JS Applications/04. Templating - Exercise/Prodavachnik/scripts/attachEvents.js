function attackEventListeners() {
    $('#linkHome').on('click', showHomeView);
    $('#linkLogin').on('click', showLoginView);
    $('#linkRegister').on('click', showRegisterView);
    $('#linkListAds').on('click', listAds);
    $('#linkCreateAd').on('click', showCreateAdFormView);
    $('#linkLogout').on('click', logoutUser);

    $('#buttonLoginUser').on('click', loginUser);
    $('#buttonRegisterUser').on('click', registerUser);
    $('#buttonCreateAd').on('click', createAd);

    $('#deleteBtn').on('click', deleteAd);

    $(document).on({
        ajaxStart: function () { $('#loadingBox').show() },
        ajaxStop: function () { $('#loadingBox').hide() }
    });
}