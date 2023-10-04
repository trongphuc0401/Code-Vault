export const oktaConfig = {
    clientId:"0oaaf2h5ehuZ5xa9k5d7",
    issuer:"https://dev-10716945.okta.com/oauth2/default",
    redirectUri:"http://localhost:3000/login/callback",
    scopes:["openid","profile","email"],
    pkce:true,
    disableHttpsCheck:true,
}