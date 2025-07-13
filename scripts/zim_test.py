import os
from playwright.sync_api import sync_playwright
from alumnium import Alumni
from alumnium.drivers.playwright_driver import PlaywrightDriver

os.environ.setdefault("ALUMNIUM_DRIVER", "playwright")

exit_code = 0

with sync_playwright() as p:
    browser = p.chromium.launch()
    page = browser.new_page()
    driver = PlaywrightDriver(page)
    page.goto("https://www.zim.com")
    al = Alumni(driver)
    try:
        al.check("page title contains ZIM")
    except Exception as e:
        print(f"Error: {e}")
        exit_code = 1
    finally:
        al.quit()
        browser.close()

print("Script finished with exit code", exit_code)
exit(exit_code)
