function revokeAccount() {
    var accounts = [];
    $("input:checked").map(function () {
        var accPar = {};
        accPar["memberid"] = this.id;
        accPar["vcashid"] = this.name;
        accounts.push(accPar);
    });
    $.ajax({
        url: '/admin/accounting/RestoreFacsimileAccounts/revoke.post.json',
        async: false,
        type: 'post',
        data: {
            accounts: JSON.stringify(accounts)
        },
        success: function (data) {
            alert(data);
        }
    });
    return false;
}