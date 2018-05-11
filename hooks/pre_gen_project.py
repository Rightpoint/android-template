import re
import sys

# Check the app name

APP_NAME_REGEX = r'[^A-Za-z0-9 ]'

app_name = '{{ cookiecutter.app_name }}'

if re.search(APP_NAME_REGEX, app_name):
    print('ERROR: please avoid using any special characters in your app name!')
    print('Include only alphanumeric characters and spaces.')

    # Exits with status 1 to indicate failure
    sys.exit(1)

# Check the package name

PACKAGE_REGEX = r'[^A-Za-z0-9.]'

package_name = '{{ cookiecutter.package_name }}'

if re.search(PACKAGE_REGEX, package_name):
    print('ERROR: %s is not a valid Android package name!' % package_name)
    print('Avoid using any special characters. Only alphanumeric characters are allowed.')

    # Exits with status 1 to indicate failure
    sys.exit(1)

# Check the directory name

DIRECTORY_REGEX = r'[^A-Za-z0-9\/]'

directory_name = '{{ cookiecutter.package_dir }}'

if re.search(DIRECTORY_REGEX, directory_name):
    print('ERROR: %s is not a valid Android package directory!' % directory_name)
    print('Avoid using any special characters. Only alphanumeric characters are allowed.')

    # Exits with status 1 to indicate failure
    sys.exit(1)

print ('Proceeding with app name: {}, package name: {}, directory name: {}'.format(app_name, package_name, directory_name))
