package it.beije.turing.xmlparser3.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import it.beije.turing.xmlparser3.Exception.TagNotOpenException;
import it.beije.turing.xmlparser3.interfaces.Elemento;
import it.beije.turing.xmlparser3.interfaces.LoadFile;


public class Documento implements LoadFile {
    private static Documento d = null;
    private TreeNode<Elemento> rootNode;

    public static Documento getIstance() {
        if (d == null) {
            d = new Documento();
        }
        return d;
    }

    private Documento() {
    }

    @Override
    public Documento parse(String path) {
        StringBuilder s = new StringBuilder();
        Stack<String> stackTag = new Stack<>();//il controllo se c'è la chiusura e apertura
        Stack<TreeNode<Elemento>> stackGER = new Stack<>();

        try {
            File f = new File(path);
            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                char row = (char) bufferedReader.read();
                s.append(row);
            }
            Pattern pattern = Pattern.compile("(<.*?>)|(.+?(?=<|$))");
            //Pattern pattern = Pattern.compile("/(<.[^(><.)]+>)/g");

            if (s.toString().contains("<!--")) {
                s = s.delete(s.indexOf("<!--"), s.indexOf("-->"));
            }


            Matcher matcher = pattern.matcher(s.toString());
            while (matcher.find()) {
                String r = matcher.group().trim();

                if (r.contains("?xml")) {
                    continue;
                }

                if (r.isEmpty()) {    //se r è vuota  salta lo spazio
                    continue;
                } else {

                    if (r.startsWith("<") && (r.endsWith(">") || r.endsWith("/>"))) { //è un TAG
                        String nameTag = parseName(r);
                        List<Attributo> attributoList = null;

                        if (!(nameTag.indexOf('/') == 0)) {   //se è un tag di apertua
                            attributoList = parseAttribute(r);

                            if (stackTag.isEmpty()) {
                                Elemento elemento = new ConcreteElement(nameTag);
                                rootNode = new TreeNode<>(elemento);
                                stackGER.push(rootNode);

                            } else {
                                TreeNode<Elemento> elementoTreeNode = new TreeNode<>(new ConcreteElement(nameTag, attributoList), stackGER.peek());
                                stackGER.push(elementoTreeNode);
                            }
                            stackTag.push(nameTag);

                        } else { //se è un tag di chiusutra check stackTag



                          /**  if(r.contains("=\"")){
                                System.out.println("attributoList");
                                List<Attributo> attr = parseAttribute(r);
                               TreeNode<Elemento> elementoTreeNode = new TreeNode<>(new ConcreteElement(nameTag, attr), stackGER.peek());

                           }else{**/
                               String e = "/" + stackTag.pop();
                               if (!nameTag.equals(e)) {
                                   throw new TagNotOpenException(e); // il tag non è stato chiuso
                               }
                               stackGER.pop();
                           }
                       // }
                    } else {
                        String contenuto = r;
                        Elemento elemento = stackGER.peek().getData();
                        elemento.setTextContent(contenuto);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.d;
    }

    public Elemento getRootElement() {
        rootNode.getData().setNode(rootNode);
        return rootNode.getData();
    }

    private List<Attributo> parseAttribute(String attr) {
        //se non ci sono attributi return null, altrimenti ritorna la lista di attributi
        List<Attributo> listAttr = new ArrayList<>();
        if (attr.contains(" ")) {
            int a = attr.indexOf(' ');
            for (int i = a; i < attr.length() - 1; i++) {
                if (attr.charAt(i) == ' ') {
                    if (attr.indexOf('=', i) != -1) {
                        String el = attr.substring(i + 1, attr.indexOf('=', i));
                        i += el.length();
                        String value = attr.substring(attr.indexOf('\"', i) + 1, attr.indexOf('\"', attr.indexOf('\"', i) + 1));
                        if (value.isEmpty()) {
                            value = "";
                        }
                        Attributo attributo = new Attributo();
                        attributo.setName(el);
                        attributo.setValue(value);
                        listAttr.add(attributo);
                    } else {
                        continue;
                    }
                }
            }
        } else {
            return listAttr;
        }
        return listAttr;
    }

    private String parseName(String attr) {
        //nome del nodo xml
        String nomeAttr = null;
        if (attr.contains(" ")) {
            nomeAttr = attr.substring(attr.indexOf('<') + 1, attr.indexOf(' '));
        } else if (attr.contains("/")) {
            nomeAttr = attr.substring(attr.indexOf('/'), attr.indexOf('>'));
        } else {
            nomeAttr = attr.substring(attr.indexOf('<') + 1, attr.indexOf('>'));
        }
        return nomeAttr;
    }


}
