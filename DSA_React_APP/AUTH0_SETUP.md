# Auth0 Setup Guide for DSA Mentor

## Step 1: Create Auth0 Account & Application

1. Go to https://auth0.com and create a free account
2. Create a new application:
   - Click "Create Application"
   - Name: `DSA Mentor`
   - Type: **Single Page Application**
   - Click "Create"

## Step 2: Configure Application Settings

In your Auth0 application settings, add these URLs:

### Allowed Callback URLs:
```
http://localhost:5173/, http://localhost:5174/, https://merajmunshiofficial.github.io/dsamentor-deploy/
```

### Allowed Logout URLs:
```
http://localhost:5173/, http://localhost:5174/, https://merajmunshiofficial.github.io/dsamentor-deploy/
```

### Allowed Web Origins:
```
http://localhost:5173, http://localhost:5174, https://merajmunshiofficial.github.io/dsamentor-deploy
```

## Step 3: Get Your Credentials

From your Auth0 application dashboard, copy:
- **Domain** (e.g., `your-app.auth0.com`)
- **Client ID** (e.g., `abc123def456...`)

## Step 4: Update Your .env File

Edit the `.env` file in your project root:

```bash
# Replace with your actual Auth0 values
VITE_AUTH0_DOMAIN=your-app.auth0.com
VITE_AUTH0_CLIENT_ID=your-actual-client-id
```

## Step 5: Test Locally

1. Save your .env file
2. Run `npm run dev` to start the development server
3. Open http://localhost:5173 and test the login

## Step 6: Deploy to Production

After confirming Auth0 works locally:
1. Run `npm run deploy-public` to deploy to GitHub Pages
2. Your app will be live at https://merajmunshiofficial.github.io/dsamentor-deploy/

## Security Notes

- Your `.env` file is in `.gitignore` and won't be pushed to GitHub
- Environment variables are compiled into the build at build time
- The Auth0 credentials are safe to use in frontend applications

## Troubleshooting

If you see "Auth0 Setup Required":
1. Check that your .env file has the correct values
2. Restart your development server after changing .env
3. Verify the URLs in your Auth0 dashboard match exactly
4. Check browser console for any Auth0 errors
