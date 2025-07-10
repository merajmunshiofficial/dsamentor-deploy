# DSA Practice App - Authentication System

This app now includes a private authentication system that only you can access.

## Default Credentials

- **Username**: `admin`
- **Password**: `DSA_Master_2025!`

## How to Change Credentials

1. Go to `src/config/auth.js`
2. Update the `USERNAME` and `PASSWORD` in the `AUTH_CONFIG` object
3. Save the file and restart the development server

## Features

- ✅ Secure login system
- ✅ Session management (24-hour expiry by default)
- ✅ Data encryption in local storage
- ✅ Automatic logout on session expiry
- ✅ Beautiful login interface
- ✅ Header with logout button

## Security Features

- Credentials are stored in a separate config file
- Session data is encrypted in local storage
- Automatic session expiry
- No credentials exposed in the main code

## Deployment

When you deploy this app to GitHub Pages or any hosting platform:

1. The authentication runs entirely in the browser
2. No backend server needed
3. Only people with your credentials can access the app
4. Sessions expire automatically for security

## Customization

You can customize the authentication system by editing:

- `src/config/auth.js` - Change credentials and settings
- `src/components/Login.jsx` - Modify the login interface
- `src/contexts/AuthContext.jsx` - Adjust authentication logic

## Session Settings

Default session duration is 24 hours. You can change this in `src/config/auth.js` by modifying the `SESSION_DURATION` value (in hours).

## Important Notes

- Keep your credentials secure
- Don't commit your actual credentials to a public repository
- Consider using environment variables for production deployments
- The app automatically redirects to login if the session expires

## Development

To run the app locally:

```bash
npm run dev
```

The app will show the login screen first, then your DSA practice interface after authentication.
