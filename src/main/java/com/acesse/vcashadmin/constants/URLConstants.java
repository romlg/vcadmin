package com.acesse.vcashadmin.constants;

public class URLConstants {
    public static class UI {
        public static final String LOGIN = "login";
        public static final String MAIN = "/";
    }

    public static class Admin {
        public static final String URL = "/admin";
        public static final String SearchMembers = "/SearchMembers";
        public static final String VCashTransfer = "/VCashTransfer";
        public static final String VCashTransferGetProductCode = VCashTransfer + "/product_codes.get.json";

        public static class Accounting {
            public static final String URL = "/accounting";
            public static final String INTERNAL_ACCOUNT = "/InternalAccounts";
            public static final String CreateVCashAccounts = "/CreateVCashAccounts";
            public static final String MemberData = "/MemberData";
            public static final String MemberDataSelectSearchCriteria = MemberData + "/search_criteria.get.json";
            public static final String NegativeBalanceAccounts = "/NegativeBalanceAccounts";
            public static final String RestoreFacsimileAccounts = "/RestoreFacsimileAccounts";
            public static final String RevokeFacsimileAccounts = RestoreFacsimileAccounts + "/revoke.post.json";
            public static final String ViewFacsimileAccounts = "/ViewFacsimileAccounts";
        }

        public static class SystemOptions {
            public static final String URL = "/systemOptions";
            public static final String Announcements = "/Announcements";
            public static final String AccessLog = "/AccessLog";
        }

        public static class EWallet {
            public static final String URL = "/eWallet";
            public static final String MemberProfileInformations = "/MemberProfileInformations";
        }
    }

    public static class View {
        public static final String LOGIN = "/login";
        public static final String MAIN = "main";

        public static final String INTERNAL_ACCOUNT = "internalaccounts";

        public static class Admin {
            public static final String SearchMembers = "admin/SearchMembers";
            public static final String VCashTransfer = "admin/VCashTransfer";

            public static class Accounting {
                public static final String CreateVCashAccounts = "/admin/accounting/CreateVCashAccounts";
                public static final String MemberData = "/admin/accounting/MemberData";
                public static final String NegativeBalanceAccounts = "/admin/accounting/NegativeBalanceAccounts";
                public static final String RestoreFacsimileAccounts = "/admin/accounting/RestoreFacsimileAccounts";
                public static final String ViewFacsimileAccounts = "/admin/accounting/ViewFacsimileAccounts";
            }

            public static class SystemOptions {
                public static final String Announcements = "/admin/systemOptions/Announcements";
                public static final String AccessLog = "/admin/systemOptions/AccessLog";
            }

            public static class EWallet {
                public static final String MemberProfileInformations = "/admin/eWallet/MemberProfileInformations";
            }
        }


    }
}
