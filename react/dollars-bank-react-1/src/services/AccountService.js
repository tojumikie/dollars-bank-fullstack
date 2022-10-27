import axios from "axios";
const ACCOUNT_API_BASE_URL = "http://localhost:8080/api/v1/accounts/";
class AccountService {
    getAccounts() {
        return axios.get(ACCOUNT_API_BASE_URL);
    }
}

export default new AccountService()