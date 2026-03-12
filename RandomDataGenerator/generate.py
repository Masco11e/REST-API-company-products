import json
import random
import string
import csv
import os

company_number =100
min_products =1
max_products =50
min_att =3
max_att =200
output_f ="products.json"

def random_string(length=8):
    return ''.join(random.choices(string.ascii_letters, k=length))

def random_value():
    return random.choice([
        str(random.randint(1, 1000)),
        f"{random.randint(1,2000)}W",
        f"{random.randint(1,200)}kg",
        f"{random.randint(1,100)}cm",
        random_string(6)
    ])

products = []
product_id = 1

for company_id in range(1, company_number + 1):

    number_of_products = random.randint(min_products, max_products)

    for _ in range(number_of_products):

        number_of_att = random.randint(min_att, max_att)
        specification = {}

        for i in range(number_of_att):
            specification[f"parameter_{i+1}"] = random_value()

        product = {
            "id": product_id,
            "company_id": company_id,
            "company_name": f"Product_{product_id}",
            "specification": specification
        }
        products.append(product)
        product_id += 1

with open(output_f, "w", encoding="utf-8") as f:
    json.dump(products, f, indent=2, ensure_ascii=False)

def convert_json_to_csv(json_file, csv_file):
    if not os.path.exists(json_file):
        print(f"JSON file not exist")
        return
    
    with open(json_file, "r", encoding="utf-8") as f:
        data = json.load(f)
    
    if not data:
        print("JSON file is empty")
        return
    
    spec_keys = set()
    for product in data:
        spec_keys.update(product.get("specification", {}).keys())
    
    spec_keys = sorted(spec_keys, key=lambda x: int(x.split("_")[1]))
    
    with open("products.csv", "w", newline="", encoding="utf-8") as f:
        writer = csv.writer(f)
        writer.writerow(["id", "company_id", "name", "specification"])

        for p in products:
            writer.writerow([
                p["id"],
                p["company_id"],
                p["company_name"],
                json.dumps(p["specification"])
            ])
    
    print(f"Converted: {json_file} --> {csv_file}")

if os.path.exists(output_f):
    convert_json_to_csv(output_f, "products.csv")