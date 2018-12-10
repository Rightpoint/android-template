#!/usr/bin/python

import os
import fnmatch
from xml.etree import ElementTree

first = None
ktlintFile = 'ktlint-report.xml'

for root, dir, files in os.walk("."):
        for items in fnmatch.filter(files, "ktlint-*.xml"):
                print root
                print dir
                data = ElementTree.parse(root + "/" + items).getroot()
                if first is None:
                        first = data
                else:
                        first.extend(data)
        if first is not None:
                f = open(ktlintFile, 'w')
                f.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n")
                f.write(ElementTree.tostring(first))
                f.close()