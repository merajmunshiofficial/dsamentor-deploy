# Deploy to Separate Public Repository
# This script builds your app and pushes only the dist folder to a public repo

Write-Host "Building and deploying DSA Mentor..." -ForegroundColor Green

# Step 1: Check for environment variables
Write-Host "Checking environment variables..." -ForegroundColor Yellow
if (-not (Test-Path ".env")) {
    Write-Host "Error: .env file not found! Please create one from .env.example" -ForegroundColor Red
    Write-Host "Refer to AUTH0_SETUP_GUIDE.md for configuration instructions" -ForegroundColor Yellow
    exit 1
}

# Step 2: Build the application
Write-Host "Building application..." -ForegroundColor Yellow
npm run build

if ($LASTEXITCODE -eq 0) {
    Write-Host "Build successful!" -ForegroundColor Green
    
    # Step 3: Navigate to dist folder
    Push-Location dist
    
    # Step 4: Initialize git in dist folder (if not already)
    if (-not (Test-Path ".git")) {
        Write-Host "Initializing git in dist folder..." -ForegroundColor Yellow
        git init
        git branch -M main
    }
    
    # Step 5: Clean sensitive data from build files
    Write-Host "Cleaning sensitive data from build files..." -ForegroundColor Yellow
    Get-ChildItem -Recurse -File -Filter "*.js" | ForEach-Object {
        (Get-Content $_.FullName) | ForEach-Object {
            $_ -replace 'sk-[a-zA-Z0-9]{32,}', 'sk-REMOVED' `
               -replace 'sk-proj-[a-zA-Z0-9-]{32,}', 'sk-proj-REMOVED' `
               -replace 'auth0\.com', 'auth0.com' `
               -replace '[a-zA-Z0-9]{32,}', 'CLIENT-ID-REMOVED'
        } | Set-Content $_.FullName
    }
    
    # Step 6: Add all files
    Write-Host "Adding files..." -ForegroundColor Yellow
    git add .
    
    # Step 7: Commit changes
    $timestamp = Get-Date -Format "yyyy-MM-dd HH:mm:ss"
    git commit -m "Deploy DSA Mentor - $timestamp"
    
    # Step 8: Push to public deployment repository
    Write-Host "Deploying to public repository..." -ForegroundColor Yellow
    
    # Add remote if not exists
    $remoteExists = git remote get-url origin 2>$null
    if (-not $remoteExists) {
        git remote add origin https://github.com/merajmunshiofficial/dsamentorai.git
    }
    
    # Push to main branch
    git push -u origin main --force
    
    if ($LASTEXITCODE -eq 0) {
        Write-Host "Deployment successful!" -ForegroundColor Green
        Write-Host "Your app will be available at:" -ForegroundColor Cyan
        Write-Host "https://merajmunshiofficial.github.io/dsamentorai/" -ForegroundColor Cyan
    } else {
        Write-Host "Deployment failed!" -ForegroundColor Red
    }
    
    # Return to original directory
    Pop-Location
} else {
    Write-Host "Build failed!" -ForegroundColor Red
}

Write-Host "Done!" -ForegroundColor Green
# Ensure .env file exists with real credentials
if (-not (Test-Path ".env")) {
    Write-Host "Creating .env file with real credentials..." -ForegroundColor Yellow
    Set-Content -Path ".env" -Value "VITE_AUTH0_DOMAIN=your-auth0-domain.us.auth0.com`nVITE_AUTH0_CLIENT_ID=your-auth0-client-id`nVITE_AUTH0_AUDIENCE=your-auth0-audience"
}

Write-Host "Using .env file for build:" -ForegroundColor Cyan
Get-Content .env